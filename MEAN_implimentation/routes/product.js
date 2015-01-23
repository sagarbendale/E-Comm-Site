var express = require('express');
var router = express.Router();
var mongoose=require('mongoose');
mongoose.model('products', {});
/* GET users listing. */

router.get('/', function(req, res) {
mongoose.model('products').find(function(err, products){
res.json(products);
});
});

router.get('/:Type', function(req, res){
var Type = req.params.Type;
mongoose.model('products').find({type:Type}, function(err, products){
res.json(products);
});
});

router.get('/:Type/:Brand', function(req, res){
var Brand = req.params.Brand;
var Type = req.params.Type;

mongoose.model('products').find({ type:Type , brand:Brand }, function(err, Brand){
res.json(Brand);
});
});

router.get('/request/service/Type', function(req, res){
	mongoose.model('products').find().distinct('type', function(err, type){
		res.json(type);
	});
});
module.exports = router;