package appDemo;

import appDemo.serviceApi.BatchService;
import appDemo.serviceApi.Service;
import appDemo.serviceImpl.BatchServiceImpl;
import appDemo.serviceImpl.ServiceImpl;
import model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShampooCompany {

    private Service<BasicIngredient, Long> basicIngredientService = new ServiceImpl<>();

    private Service<BasicShampoo, Long> basicShampooService = new ServiceImpl<>();

    private BatchService productionBatchService = new BatchServiceImpl();

    public static void main(String[] args) {
        ShampooCompany app = new ShampooCompany();
        app.run();
    }

    private void run() {

        BasicIngredient mint = new Mint();
        BasicIngredient strawberry = new Strawberry();
        BasicIngredient strawberry_2 = new Strawberry();
        BasicIngredient amoniumCloride = new AmoniumCloride();
        basicIngredientService.save(mint);
        basicIngredientService.save(strawberry);
        basicIngredientService.save(strawberry_2);
        basicIngredientService.save(amoniumCloride);

        BasicIngredient bi_1 = basicIngredientService.findById(BasicIngredient.class, 1L);
        BasicIngredient bi_2 = basicIngredientService.findById(BasicIngredient.class, 2L);
        BasicIngredient bi_3 = basicIngredientService.findById(BasicIngredient.class, 3L);
        BasicIngredient bi_4 = basicIngredientService.findById(BasicIngredient.class, 4L);

        ClassicLabel label = new ClassicLabel("Fresh Shine");
        BasicShampoo shampoo = new FreshNuke();
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(mint);
        ingredients.add(strawberry);
        ingredients.add(amoniumCloride);
        shampoo.setBasicIngredients(ingredients);
        shampoo.setLabel(label);


        ProductionBatch productionBatch = new ProductionBatch();
        shampoo.setProductionBatch(productionBatch);

        basicShampooService.save(shampoo);

        List<ProductionBatch> pb = productionBatchService.findAll(ProductionBatch.class);
       productionBatchService.printBatch(pb.get(0)); // dont work, need join with another session!!!
    }
}
