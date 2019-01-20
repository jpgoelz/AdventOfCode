import React, { Component } from "react";
import "./App.css";
import Controller from "../helper/Controller";
import PrimarySearchAppBar from "./appbar/PrimarySearchAppBar";

class App extends Component {
  render() {
    return (
      <div className="App">
        <PrimarySearchAppBar />
        <Controller />
      </div>
    );
  }
}

export default App;
