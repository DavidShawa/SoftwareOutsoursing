package com.example.softwareoutsoursing.service.impl;

import com.example.softwareoutsoursing.entity.User;
import com.example.softwareoutsoursing.mapper.UserMapper;
import com.example.softwareoutsoursing.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XYZ
 * @since 2023-03-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
