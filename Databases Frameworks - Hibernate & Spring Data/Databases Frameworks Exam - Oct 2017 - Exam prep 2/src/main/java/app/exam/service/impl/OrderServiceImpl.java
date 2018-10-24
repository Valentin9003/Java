package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeOrdersJSONExportDTO;
import app.exam.domain.dto.json.ItemJSONExportDTO;
import app.exam.domain.dto.json.OrderJSONExportDTO;
import app.exam.domain.dto.xml.OrderXMLImportDTO;
import app.exam.domain.entities.*;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.OrderRepository;
import app.exam.service.api.EmployeeService;
import app.exam.service.api.ItemsService;
import app.exam.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelParser modelParser;
    private final EmployeeService employeeService;
    private final ItemsService itemsService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ModelParser modelParser,
                            EmployeeService employeeService,
                            ItemsService itemsService) {
        this.orderRepository = orderRepository;
        this.modelParser = modelParser;
        this.employeeService = employeeService;
        this.itemsService = itemsService;
    }

    @Override
    public void create(OrderXMLImportDTO dto) {
//        Order convert = this.modelParser.convert(dto, Order.class);
        Order order = new Order(dto.getCustomer(), dto.getDate(), OrderType.valueOf(dto.getType()));
        Employee employee = this.employeeService.oneByName(dto.getEmployee());
        if (employee == null) {
            throw new IllegalArgumentException();
        }
        order.setEmployee(employee);

        List<OrderItem> orderItemsList = new ArrayList<>();
        dto.getItems().forEach(itemDto -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(itemDto.getQuantity());

            Item item = this.itemsService.findByName(itemDto.getName());
            if (item == null) {
                throw new IllegalArgumentException();
            }
            orderItem.setItem(item);
            orderItem.setOrder(order);

            orderItemsList.add(orderItem);
        });
        order.setOrderItems(orderItemsList);

        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public EmployeeOrdersJSONExportDTO exportOrdersByEmployeeAndOrderType(String employeeName, String orderType) {
        List<Order> orderList =
                this.orderRepository
                        .findAllByEmployeeNameAndType(employeeName, OrderType.valueOf(orderType));

        orderByTotalPriceDescThenByNumberOfItemsDesc(orderList);

        EmployeeOrdersJSONExportDTO employeeOrdersJSONExportDtos = new EmployeeOrdersJSONExportDTO();
        employeeOrdersJSONExportDtos.setEmployeeName(employeeName);
        List<OrderJSONExportDTO> orderJSONExportDTOS =
                orderList.stream()
                        .map(order -> {
                            OrderJSONExportDTO orderDto = new OrderJSONExportDTO();
                            orderDto.setCustomer(order.getCustomer());

                            List<ItemJSONExportDTO> itemJSONExportDTOS =
                                    order.getOrderItems().stream()
                                            .map(item -> {
                                                ItemJSONExportDTO itemDto = new ItemJSONExportDTO();
                                                itemDto.setName(item.getItem().getName());
                                                itemDto.setPrice(item.getItem().getPrice());
                                                itemDto.setQuantity(item.getQuantity());
                                                return itemDto;
                                            })
                                            .collect(Collectors.toList());

                            orderDto.setItems(itemJSONExportDTOS);
                            return orderDto;
                        })
                        .collect(Collectors.toList());

        employeeOrdersJSONExportDtos.setOrders(orderJSONExportDTOS);

        return employeeOrdersJSONExportDtos;
    }

    private void orderByTotalPriceDescThenByNumberOfItemsDesc(List<Order> orderList) {
        Collections.sort(orderList, (o1, o2) -> {
            BigDecimal p1 = ((Order)o1).getTotalPrice();
            BigDecimal p2 = ((Order)o2).getTotalPrice();
            int sComp = p2.compareTo(p1);

            if (sComp != 0) {
                return sComp;
            }

            Integer size1 = ((Order) o1).getOrderItems().size();
            Integer size2 = ((Order) o2).getOrderItems().size();

            return size2.compareTo(size1);
        });
    }
}
