 var current = new Date();
        sdate = new Date($scope.product[0].sdate);
        edate=$scope.product[0].edate
        if(edate)
        {
          edate=new Date(edate);
         }
        
        if(!edate)
        {
                 $scope.product[0]["check"] = 'true';
                 
                  
       }
      else
      {
                   if(sdate < current   &&  current < edate)
                   {
                      $scope.product[0]["check"] = 'true';
                    
                   }
                   else
                   {
                      $scope.product[0]["check"] = 'false';
                      
                   }
      }