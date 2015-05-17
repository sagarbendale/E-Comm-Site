from bottle import route, run
from bottle import request,response
from mysql.connector import errorcode
import os, inspect, json
from json import dumps
import mysql.connector
from pymongo import Connection
from bson import Binary, Code
from bson.json_util import dumps
import datetime
import time

connection = Connection('localhost', 27017)
db = connection.mydatabase



@route('/shirt', method='GET')
def shirtAllShow(shirtId="Show Shirt" ):
	data = db['documents'].find()
	print(data)
 	if data == None:
 		return json.dumps({'Status':"Bad Request! Please Check the Request"})
 	else:
 		print(data)
 	return dumps(data)

@route('/shirt/<shirtId>', method='GET')
def shirtShow(shirtId="Show Shirt" ):
	data = db['documents'].find_one({'shirtId':shirtId})
	print(data)
 	if data == None:
 		return json.dumps({'Status':"Bad Request! Please Check the Request"})
 	else:
 		print(data)
 	return dumps(data)

@route('/shirts', method='PUT')
def shirtPut():
	data = json.load(request.body)
	print "data : %s" % data 
 	if data == None:
 		return json.dumps({'Status':"Bad Request! Please Check the Request"})
 	else:
 		try:
 			db['documents'].update({"shirtId": data['shirtId']}, {"$set": data });
 			return json.dumps({'Status':"OK"})
 		except StandardError as ve:
 			return json.dumps({'Status':"Bad Request! Please Check the Request"})

@route('/shirts', method='POST')
def shirtPost():
	data = json.load(request.body)
	ts = time.time()
	st = datetime.datetime.fromtimestamp(ts).strftime('%Y-%m-%d %H:%M:%S')
	print(st)
	print "data : %s" % data 
 	if data == None:
 		return json.dumps({'Status':"Bad Request! Please Check the Request"})
 	else:
 		try:
 			data['createdDate']=st
 			db['documents'].insert(data)
 			return 'OK'
 		except StandardError as ve:
 			return json.dumps({'Status':"Bad Request! Please Check the Request"})



@route('/shirts', method='DELETE')
def shirtDelete():
	data = json.load(request.body)
	print "data : %s" % data 
 	if data == None:
 		return json.dumps({'Status':"Bad Request! Please Check the Request"})
 	else:
 		try:
 			db['documents'].remove(data)
 			return 'OK'
 		except StandardError as ve:
 			return json.dumps({'Status':"Bad Request! Please Check the Request"})




@route('/shoe', method='GET')
def shoeAllShow():
	output=""
	try:
	  cnx = mysql.connector.connect(user='root',password='273demo',database='ecommapp')
	  cursor = cnx.cursor()
	  cursor.execute("SELECT CONCAT('[ ',GROUP_CONCAT( CONCAT('{ \"shoeId\" : ',shoeId), CONCAT(', \"shoeName\" : \"',shoeName) ,CONCAT('\", \"shoeQuantity\" : ',shoeQuantity),CONCAT(', \"createdBy\" : \"',createdBy),CONCAT('\", \"createdDate\" : \"', createdDate),'\" }'),' ]')AS json FROM shoes")
	  result = cursor.fetchall()
	  temp = json.dumps(result[0])  
	  output=json.loads(temp);
	  print output
	except mysql.connector.Error as err:
	  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
	    return json.dumps({'Status':"Bad Request! Please Check the Request"})
	  elif err.errno == errorcode.ER_BAD_DB_ERROR:
	    return json.dumps({'Status':"Bad Request! Please Check the Request"})
	  else:
	    print(output)
	else:
	  cnx.close()
	response.content_type = 'application/json'
	return output







@route('/shoe/<shoeId>', method='GET')
def shoeShow( shoeId="Show Shoe" ):
	output=""
	try:
	  cnx = mysql.connector.connect(user='root',password='273demo',database='ecommapp')
	  cursor = cnx.cursor()
	  cursor.execute("select * from shoes where shoeID= %s" %shoeId)
	  result = cursor.fetchall()
	  output = { "shoeId": result[0][0], "shoeName": result[0][1],"shoeQuantity":result[0][2],"createdBy":result[0][3],"Creation Date":result[0][4].strftime('%m/%d/%Y %HH:%MM:%SS') }
	  print output
	except mysql.connector.Error as err:
	  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
	    return json.dumps({'Status':"Bad Request! Please Check the Request"})
	  elif err.errno == errorcode.ER_BAD_DB_ERROR:
	    return json.dumps({'Status':"Bad Request! Please Check the Request"})
	  else:
	    print(result)
	else:
	  cnx.close()
	response.content_type = 'application/json'
	return dumps(output)


@route('/shoes', method='POST')
def	shoePOST():
    data = json.load(request.body)
    print "data : %s" % data 
    if data == None:
        return json.dumps({'Status':"No Data Found In Request! Please Check the Request"})
    else:
		try:
		  cnx = mysql.connector.connect(user='root',password='273demo',database='ecommapp')
		  cursor = cnx.cursor()
		  add_shoe = ("INSERT INTO shoes(shoeId,shoeName,shoeQuantity,createdBy) VALUES (%(shoeId)s, %(shoeName)s, %(shoeQuantity)s, %(createdBy)s)")
		  cursor.execute(add_shoe,data)
		  cnx.commit()
		  print "Data Inserted"
		except mysql.connector.Error as err:
		  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  elif err.errno == errorcode.ER_BAD_DB_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  else:
		    print(err)
		else:
		  cnx.close()

    return 'OK'



@route('/shoes', method='DELETE' )
def shoeDelete():
    data = json.load(request.body)
    print "data : %s" % data 
    if data == None:
        return json.dumps({'Status':"No Data Found In Request! Please Check the Request"})
    else:
		try:
		  cnx = mysql.connector.connect(user='root',password='273demo',database='ecommapp')
		  cursor = cnx.cursor()
		  add_shoe = ("delete from shoes where shoeId=%(shoeId)s ")
		  cursor.execute(add_shoe,data)
		  cnx.commit()
		  print "Data Deleted"
		except mysql.connector.Error as err:
		  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  elif err.errno == errorcode.ER_BAD_DB_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  else:
		    print(err)
		else:
		  cnx.close()

    return 'OK'


@route('/shoes', method='PUT')
def shoePut():
    data = json.load(request.body)
    print "data : %s" % data 
    if data == None:
        return json.dumps({'Status':"No Data Found In Request! Please Check the Request"})
    else:
		try:
		  cnx = mysql.connector.connect(user='root',password='273demo',database='ecommapp')
		  cursor = cnx.cursor()
		  total=0;
		  for key, value in data.items():
			total = total +1
		  print(total)
		  statement="update shoes set "
		  for key, value in data.items():
		  	statement=statement + key +" = \'"+value+"\'"
			if total != 1:
				statement=statement+","
				total = total -1
		  statement=statement+" where shoeId = "+data['shoeId']
		  cursor.execute(statement)
		  cnx.commit()
		  print "Data Updated"
		except mysql.connector.Error as err:
		  if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  elif err.errno == errorcode.ER_BAD_DB_ERROR:
		    return json.dumps({'Status':"Bad Request! Please Check the Request"})
		  else:
		    print(err)
		else:
		  cnx.close()

    return 'OK'


run(host='0.0.0.0', port=8080)
