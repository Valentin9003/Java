package users.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.system.repositories.TownRepo;
import users.system.service.interfaces.TownService;

import javax.transaction.Transactional;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    private final TownRepo townRepo;

    @Autowired
    public TownServiceImpl(TownRepo townRepo) {
        this.townRepo = townRepo;
    }
}
