package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
@Api(tags = "套餐相关接口")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @PostMapping
    @ApiOperation("新增套餐接口")
    public Result saveWithDishSetmeal(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐");
        setmealService.saveWithDishSetmeal(setmealDTO);
        return Result.success();
    }

    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        PageResult pageResult = setmealService.page(setmealPageQueryDTO);
        return Result.success(pageResult);
    }
    @DeleteMapping
    @ApiOperation("批量删除套餐")
    public Result delete(List<Long> ids){
        setmealService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id来查询套餐
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id来查询套餐")
    public Result<SetmealVO> queryById(@PathVariable Long id){
        SetmealVO setmealVO = setmealService.queryById(id);
        return Result.success(setmealVO);
    }
    @PutMapping
    @ApiOperation("修改套餐信息")
    public Result update(@RequestBody SetmealDTO setmealDTO){
        setmealService.update(setmealDTO);
        return Result.success();
    }
    @PostMapping("/status/{status}")
    @ApiOperation("修改套餐起售、停售")
    public Result update(@PathVariable Integer status,Long id){
        setmealService.updateStatus(status,id);
        return Result.success();
    }
}
