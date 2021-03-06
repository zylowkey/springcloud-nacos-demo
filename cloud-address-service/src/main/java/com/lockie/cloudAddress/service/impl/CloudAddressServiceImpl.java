package com.lockie.cloudAddress.service.impl;

import com.lockie.cloudAddress.mapper.ShopAddressMapper;
import com.lockie.cloudAddress.model.ShopAddress;
import com.lockie.cloudAddress.service.CloudAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: lockie
 * @Date: 2020/9/9 14:04
 * @Description:
 */
@Service
public class CloudAddressServiceImpl implements CloudAddressService {

    @Autowired
    ShopAddressMapper shopAddressMapper;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public ShopAddress getAddressById(Integer id) {
        if (id == null) {
            return null;
        }
        return shopAddressMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存订单地址
     * @param shopAddress
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveShopAddress(ShopAddress shopAddress) throws Exception {
        shopAddress.setCreateBy(1);
        shopAddress.setCreateDate(new Date());
        shopAddress.setUpdateBy(1);
        shopAddress.setUpdateDate(new Date());

        int i = shopAddressMapper.insert(shopAddress);
        return i;
    }

    /**
     * 根据订单ID查询
     * @param orderId
     * @return
     */
    @Override
    public ShopAddress getAddressByOrderId(Integer orderId) {
        if (orderId == null) {
            return null;
        }
        return shopAddressMapper.getAddressByOrderId(orderId);
    }
}
