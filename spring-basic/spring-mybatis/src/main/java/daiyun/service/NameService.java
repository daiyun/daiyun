package daiyun.service;

import daiyun.pojo.Name;

import java.util.List;

/**
 * @author godaiyun
 * @date 2018-11-08 17:21.
 */
public interface NameService {

  List<Name> selectAll();

  int selectByName(String name);
}
