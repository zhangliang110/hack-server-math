##### 单元测试之 mockito的总结
- 单元测试区别于集成测试：不应该依赖于web容器，mysql 等数据库链接等，他应该尽可能的覆盖
到方法的所有分支和各种参数输入情况；它应该执行速度非常快；他应该简洁明了。
- mockito 主要分为
    - mock 相关依赖和对象比如：mock 数据库mapper 
    - mockito 的assertThat 能给方便快捷的进行输出参数的预期判断
    - mockito 通过 BaseMatcher扩展类，我们可以非常轻松的实现各种自定的matcher丰富自己的判断能力
    - mockito 主要是通过mock各种依赖，来校验程序的逻辑执行是否正确。