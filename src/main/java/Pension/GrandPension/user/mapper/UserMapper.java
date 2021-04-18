package Pension.GrandPension.user.mapper;

import Pension.GrandPension.user.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUserName(String username);


}
