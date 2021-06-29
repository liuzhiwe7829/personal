Select m.Branch_Code,
       Gen_Prem_Notax_m 实际值,
       Round(n.Target_Value /
             (Select Count(1)
                From System_Work_Day
               Where Work_Date Between Date '2019-01-01' And Date
               '2019-12-31'
                 And Is_Work = '1'),
             2) 日目标值,
       Round(n.Target_Value *
             (Select Count(1)
                From System_Work_Day
               Where Work_Date Between Date '2019-10-01' And Date
               '2019-10-31'
                 And Is_Work = '1') /
             (Select Count(1)
                From System_Work_Day
               Where Work_Date Between Date '2019-01-01' And Date
               '2019-12-31'
                 And Is_Work = '1'),
             2) 十月份目标值,
       n.Target_Value 年目标值
  From (Select t.Branch_Code, Sum(g.Gen_Prem_Notax_m) Gen_Prem_Notax_m
          From System_Branch t, Agg_Business_Manage_Day g
         Where g.Companycode Like t.Branch_Code || '%'
           And t.Parent_Branch = '01'
         Group By t.Branch_Code) m,
       Stat_Item_Target n
 Where m.Branch_Code = n.Branch_Code
   And n.Item_Code = 'ZB000001'
   And n.Product_Code = 'P00'
   And n.Channel_Code = '0'
