package com.atguigu.spzx.manager.commmon.dto;/**
 * ClassName: StudyDTOTest
 * Package: com.atguigu.spzx.manager.commmon.dto
 * Description:
 *
 * @Author wangzijie
 * @Create 2025/10/5 10:09
 * @Version 1.0
 */

import org.junit.jupiter.api.Test;

/**
 * <p>标题: </p>
 * <p>功能描述: </p>
 *
 * <p>创建时间: 2025/10/5 10:09</p>
 * <p>作者：王贤 </p>
 * <p>修改历史记录：</p>
 * ====================================================================<br>
 * 维护单：<br>
 * 修改日期：<br>
 * 修改人：<br>
 * 修改内容：<br>
 */
public class StudyDTOTest {
    @Test
    public void test() {
        StudyDTO studyDTO = new StudyDTO();
        // 谁都可以随便修改，而且没有限制
        studyDTO.setSalary(1.2);
        studyDTO.setName("王子接");


        test2(studyDTO);

    }

    public void  test2(StudyDTO studyDTO){
        System.out.println(studyDTO.getSalary());
    }

}
