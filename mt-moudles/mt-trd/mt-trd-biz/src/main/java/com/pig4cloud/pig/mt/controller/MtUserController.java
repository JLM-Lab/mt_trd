/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.pig4cloud.pig.mt.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.mt.entity.MtUser;
import com.pig4cloud.pig.mt.service.MtUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author JLM
 * @date 2021-03-03 18:21:48
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/mtuser" )
@Api(value = "mtuser", tags = "管理")
public class MtUserController {

    private final  MtUserService mtUserService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param mtUser 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('mt_mtuser_get')" )
    public R getMtUserPage(Page page, MtUser mtUser) {
        return R.ok(mtUserService.page(page, Wrappers.query(mtUser)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('mt_mtuser_get')" )
    public R getById(@PathVariable("id" ) String id) {
        return R.ok(mtUserService.getById(id));
    }

    /**
     * 新增
     * @param mtUser 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('mt_mtuser_add')" )
    public R save(@RequestBody MtUser mtUser) {
        return R.ok(mtUserService.save(mtUser));
    }

    /**
     * 修改
     * @param mtUser 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('mt_mtuser_edit')" )
    public R updateById(@RequestBody MtUser mtUser) {
        return R.ok(mtUserService.updateById(mtUser));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('mt_mtuser_del')" )
    public R removeById(@PathVariable String id) {
        return R.ok(mtUserService.removeById(id));
    }

}
