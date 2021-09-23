$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/textBox.feature");
formatter.feature({
  "name": "TextBox option tests",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Testing textbox elemenrs",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am navigating to the \u003cURI\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I click on textbox option",
  "keyword": "When "
});
formatter.step({
  "name": "I enter all the textbox enterDetails",
  "keyword": "And "
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "URI"
      ]
    },
    {
      "cells": [
        "https://demoqa.com/elements"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Testing textbox elemenrs",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I am navigating to the https://demoqa.com/elements",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I click on textbox option",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I enter all the textbox enterDetails",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I quit the application",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});