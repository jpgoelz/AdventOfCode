import React, { Component } from "react";
import "./App.css";
import Controller from "./Controller";
import { Link } from "react-router-dom";
import Button from "@material-ui/core/Button";

class App extends Component {
  render() {
    return (
      <div className="App">
        <Button component={Link} to="/adventOfCode">
          Advent of Code
        </Button>
        <Controller />
      </div>
    );
  }
}

export default App;
