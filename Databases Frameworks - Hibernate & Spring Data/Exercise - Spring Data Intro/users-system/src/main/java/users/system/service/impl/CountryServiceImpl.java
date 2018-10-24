package users.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.system.repositories.CountryRepo;
import users.system.service.interfaces.CountryService;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepo countryRepo;

    @Autowired
    public CountryServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }
}
