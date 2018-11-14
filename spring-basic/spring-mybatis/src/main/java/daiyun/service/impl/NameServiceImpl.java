package daiyun.service.impl;

import daiyun.dao.NameDao;
import daiyun.pojo.Name;
import daiyun.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author godaiyun
 * @date 2018-11-08 17:22.
 */
@Service
public class NameServiceImpl implements NameService {

  @Autowired
  private NameDao nameDao;

  @Override
  public List<Name> selectAll() {
    return nameDao.selectAll();
  }

  @Override
  public int selectByName(String name) {

    System.out.println("service");
    return nameDao.selectByName(name);
  }

  @Override
  public void delByName(String name) {
    System.out.println("do del");

    nameDao.deleteByName(name);
  }


}
