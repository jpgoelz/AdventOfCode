import React, { Component } from "react";
import "./App.css";
import Controller from "../helper/Controller";
import PrimarySearchAppBar from "./appbar/PrimarySearchAppBar";
import CardTemplate from "./cards/CardTemplate";
import Grid from "@material-ui/core/Grid";
import PuzzleCard from "./cards/PuzzleCard";

class App extends Component {
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
          <CardTemplate cardType={"newCard"} />
          <CardTemplate cardType={"puzzleCard"} />
          <CardTemplate cardType={"puzzleCard"} />
        </Grid>
        <Controller />
      </div>
    );
  }
}

export default App;
