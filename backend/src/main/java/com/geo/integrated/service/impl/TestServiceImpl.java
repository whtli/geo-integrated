package com.geo.integrated.service.impl;

import com.geo.integrated.exception.ServiceException;
import com.geo.integrated.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author: whtli
 * @date: 2023/01/29
 * @description:
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public void testGlobalException(String testString) {
       throw new ServiceException(500, "测试记录异常日志");
    }
}
