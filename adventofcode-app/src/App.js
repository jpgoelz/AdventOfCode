import React, { Component } from "react";
import "./App.css";
import Controller from "./Controller";
import Typography from "@material-ui/core/Typography";

class App extends Component {
  render() {
    return (
      <div className="App">
        <Typography variant="h5" component="h2" style={{ marginTop: 20 }}>
          Advent of Code
        </Typography>
        <Controller />
      </div>
    );
  }
}

export default App;
