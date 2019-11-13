# BDPDashboard

入口文件：com.aura.training.dashboard.DashboardApplication
启动端口： 8080
接口放在: controller目录下，参考UserOrderController

启动后可以访问http://localhost:8080/ 页面

开发建议：
本项目只做rest api开发和结果展示页面。spark等后台程序单独建立项目，不要放在本项目里。
spark等任务将结果写入mysql，在本项目读取展示

本项目采用前后端分离的方式，前端页面使用ajax访问接口，展示数据。

