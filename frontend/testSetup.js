const chai = require("chai");
const sinon = require("sinon");

require("react-native-mock/mock.js");

global.sinon = sinon;
global.expect = chai.expect;
