import React, { Component } from "react";
import "./App.css";
import Controller from "../helper/Controller";
import PrimarySearchAppBar from "./appbar/PrimarySearchAppBar";
import CardTemplate from "./cards/CardTemplate";
import Grid from "@material-ui/core/Grid";
import PuzzleCard from "./cards/PuzzleCard";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      part: "",
    };
    this.setCartTemplateState = this.setCartTemplateState.bind(this);
  }

  render() {
    return (
      <div className="App">
        <PrimarySearchAppBar />
        <Grid
          container
          direction="row"
          justify="flex-start"
          alignItems="flex-start"
          style={{ margin: 10 }}
        >
          <CardTemplate callback={this.setCartTemplateState} cardType={"newCard"} />
          <CardTemplate callback={this.setCartTemplateState} cardType={"puzzleCard"} day={"1"} result={"Part 2 - Frequency reached twice: 81204"}/>
          <CardTemplate callback={this.setCartTemplateState} cardType={"puzzleCard"} day={"1"} result={"Part 1 - Frequency: 599"}/>
        </Grid>
      </div>
    );
  }

  setCartTemplateState(value) {
    this.setState(value);
  }
}

export default App;
