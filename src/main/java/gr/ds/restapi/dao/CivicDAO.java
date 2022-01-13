package gr.ds.restapi.dao;

import gr.ds.restapi.entity.CivicOfficial;

import java.util.List;

public class CivicDAO implements UserDAO<CivicOfficial> {
    @Override
    public List<CivicOfficial> showALl() {
        return null;
    }

    @Override
    public int addUser(CivicOfficial user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public int updateUser(CivicOfficial user) {
        return 0;
    }
}
