package com.book.bookstore.service;

import com.book.bookstore.beans.Category;
import com.book.bookstore.mapper.CategoryMapper;
import com.book.bookstore.module.BaseRequest;
import com.book.bookstore.module.UpdateRequest;
import com.book.bookstore.serviceImpl.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements CategoryImpl {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List getCategory(){
        List<Category> categories = categoryMapper.selectAll();
        List<Map> mapList = new ArrayList<>();
        for(Category category : categories){
            Map map = new HashMap();
            map.put("id",category.getId());
            map.put("catename",category.getCatename());
            map.put("cateInfo",category.getCateInfo());
            mapList.add(map);
        }
        return mapList;
    }
    @Override
    public void updateCategory(UpdateRequest request){
        Category category = categoryMapper.selectByPrimaryKey(request.getId());
        category.setCatename(request.getCatename());
        category.setCateInfo(request.getCateInfo());
        categoryMapper.updateByPrimaryKeySelective(category);
    }
    @Override
    public void addCategory(BaseRequest request){
        Category category = new Category();
        category.setCatename(request.getCatename());
        category.setCateInfo(request.getCateInfo());
        categoryMapper.insert(category);
    }

    public int selectCategoryIdByCatename(String catename){
        return categoryMapper.selectCategoryIdByCatename(catename);
    }
    public Category getCategoryById(int id){
        return categoryMapper.selectByPrimaryKey(id);
    }
    @Override
    public List searchCategory(String catename){
        List<Category> categories = categoryMapper.searchCategory(catename);
        List<Map> listMap = new ArrayList<>();
        for(Category category : categories){
            Map map = new HashMap();
            map.put("id",category.getId());
            map.put("catename",category.getCatename());
            map.put("cateInfo",category.getCateInfo());
            listMap.add(map);
        }
        return listMap;
    }

    public void delCategory(Integer id){
        categoryMapper.deleteByPrimaryKey(id);
    }
}
