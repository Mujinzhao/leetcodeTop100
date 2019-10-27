-- Employee 表包含所有员工信息，每个员工有其对应的工号 Id，姓名 Name，工资 Salary 和部门编号 DepartmentId 。
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 85000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- | 5  | Janet | 69000  | 1            |
-- | 6  | Randy | 85000  | 1            |
-- | 7  | Will  | 70000  | 1            |
-- +----+-------+--------+--------------+
-- Department 表包含公司所有部门的信息。
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- 编写一个 SQL 查询，找出每个部门获得前三高工资的所有员工。例如，根据上述给定的表，查询结果应返回：
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Randy    | 85000  |
-- | IT         | Joe      | 85000  |
-- | IT         | Will     | 70000  |
-- | Sales      | Henry    | 80000  |
-- | Sales      | Sam      | 60000  |
-- +------------+----------+--------+
-- 解释：
--
-- IT 部门中，Max 获得了最高的工资，Randy 和 Joe 都拿到了第二高的工资，Will 的工资排第三。销售部门（Sales）只有两名员工，Henry 的工资最高，Sam 的工资排第二。

select Department.Name as Department,temp.name as Employee,temp.Salary as Salary
from
(select A.DepartmentId as DepartmentId,A.Name as name,A.Salary as Salary
from Employee A left join Employee B on A.DepartmentId = B.DepartmentId
where A.Salary <= B.Salary
group by A.Id,A.Name,A.DepartmentId,A.Salary
having count(distinct(B.Salary)) <= 3) as temp,
Department
where temp.DepartmentId = Department.Id
order by Department.Name asc,temp.Salary desc,temp.name asc


解析：这一题最难写的可能就是 为什么是distinct(B.Salary) 了
可以这么理解：每个人比较的是 部门中有哪几种不同的工资高于自己，而不是哪几个人的工资高于自己！！

这一题就是分数排名的升级版