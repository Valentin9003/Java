package users.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.system.repositories.AlbumRepo;
import users.system.service.interfaces.AlbumService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepo albumRepo;

    @Autowired
    public AlbumServiceImpl(AlbumRepo albumRepo) {
        this.albumRepo = albumRepo;
    }
}
