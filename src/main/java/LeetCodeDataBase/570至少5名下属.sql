-- //Employee 表包含所有员工和他们的经理。每个员工都有一个 Id，并且还有一列是经理的 Id。
-- //
-- // +------+----------+-----------+----------+
-- //|Id    |Name       |Department |ManagerId |
-- //+------+----------+-----------+----------+
-- //|101   |John       |A         |null      |
-- //|102   |Dan    |A         |101       |
-- //|103   |James   |A         |101       |
-- //|104   |Amy    |A         |101       |
-- //|105   |Anne       |A         |101       |
-- //|106   |Ron    |B         |101       |
-- //+------+----------+-----------+----------+
-- //
-- //
-- // 给定 Employee 表，请编写一个SQL查询来查找至少有5名直接下属的经理。对于上表，您的SQL查询应该返回：
-- //
-- // +-------+
-- //| Name  |
-- //+-------+
-- //| John  |
-- //+-------+
-- //
-- //
-- // 注意:
-- //没有人是自己的下属。
-- //


select Name
from Employee
where Id in
(select temp.ManagerId
from (select * from Employee where Id != ManagerId) as temp
group by temp.ManagerId
having count(*) >= 5)

select A.Name as Name
from Employee A left join Employee B on A.Id = B.ManagerId
group by A.Id
having count(*) > 5