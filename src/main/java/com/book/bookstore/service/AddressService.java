package com.book.bookstore.service;

import com.book.bookstore.beans.Address;
import com.book.bookstore.mapper.AddressMapper;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressService implements AddressImpl{

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List getAddress(Integer userId){
        List<Address> addresses = addressMapper.selectByUserId(userId);
        List<Map> mapList = new ArrayList<>();
        for(Address address : addresses){
            Map map = new HashMap();
            map.put("id",address.getId());
            map.put("province",address.getProvince());
            map.put("city",address.getCity());
            map.put("area",address.getCounty());
            map.put("specific",address.getJuti());
            mapList.add(map);
        }
        return mapList;
    }
    public List getSelectAddress(Integer userId){
        List<Address> addresses = addressMapper.selectByUserId(userId);
        List<Map> mapList = new ArrayList<>();
        for(Address address : addresses){
            Map map = new HashMap();
            map.put("id",address.getId());
            map.put("value",address.getProvince()+address.getCity()+address.getCounty()+
                    address.getJuti());
            mapList.add(map);
        }
        return mapList;
    }

    public Address getAddress2(Integer id){
       return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addAddress(BaseRequest request){
        Address address = new Address();
       address.setProvince(request.getProvince());
        address.setCity(request.getCity());
        address.setCounty(request.getCounty());
        address.setJuti(request.getSpecific());
        address.setUserId(request.getUserId());
        addressMapper.insert(address);

    }

    @Override
    public void delAddress(Integer id){
        addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateAddress(UpdateRequest request){
        Address address = addressMapper.selectByPrimaryKey(request.getId());
        address.setProvince(request.getProvince());
        address.setCity(request.getCity());
        address.setCounty(request.getCounty());
        address.setJuti(request.getSpecific());
        address.setUserId(request.getUserId());
        addressMapper.updateByPrimaryKeySelective(address);
    }
}
