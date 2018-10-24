package users.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.system.repositories.PictureRepo;
import users.system.service.interfaces.PictureService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    private final PictureRepo pictureRepo;

    @Autowired
    public PictureServiceImpl(PictureRepo pictureRepo) {
        this.pictureRepo = pictureRepo;
    }
}
