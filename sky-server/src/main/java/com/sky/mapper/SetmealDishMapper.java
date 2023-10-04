package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应套餐id
     * @param dishIds
     * @return
     */
    //select setmeal_id from setmeal_dish where dish_id in(1,2,3,4);
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 添加菜品和套餐关系
     * @param setmealDishes
     */
    void insert(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id查询对应的菜品和套餐关系
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getById(Long setmealId);

    /**
     * 根据套餐id来删除套餐菜品关系
     * @param id
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{id}")
    void deleteBySetmealId(Long id);

}
