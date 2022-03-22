package leetcode

@Suppress("ClassName", "unused")
class _0178 {

    // SQL
    // 要关注可能表内只有一条记录
    // 考察两个sql功能：AS 别名、IFNULL 判空
    /**
     *
     *  select
     *      ifnull(
     *          (select distinct salary
     *              from employee
     *              order by salary desc
     *              limit 1 offset 1),
     *          null
     *      ) as resultTable
     *
     *
     * **/
}