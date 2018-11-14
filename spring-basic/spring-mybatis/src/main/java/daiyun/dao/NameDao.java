package daiyun.dao;

import daiyun.pojo.Name;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author godaiyun
 * @date 2018-11-08 17:07.
 */

public interface NameDao {

  Integer selectByName(@Param("name") String name);

  List<Name> selectAll();

  void insert(@Param("id") int id, @Param("name") String name);

  void deleteByName(@Param("name") String name);

  void deleteById(@Param("id") int id);
}
