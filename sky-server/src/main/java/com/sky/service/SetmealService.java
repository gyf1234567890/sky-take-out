package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {

    /**
     * 新增套餐接口
     * @param setmealDTO
     */
    void saveWithDishSetmeal(SetmealDTO setmealDTO);

    /**
     * 套餐分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 删除套餐
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 修改套餐信息
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);


    SetmealVO queryById(Long id);

    /**
     * 修改套餐状态
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);
}
