import React, { Component } from "react";
import "./App.css";
import PrimarySearchAppBar from "./appbar/PrimarySearchAppBar";
import CardTemplate from "./cards/CardTemplate";
import Grid from "@material-ui/core/Grid";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      part: "",
      solved: { 1: {day: "1", part: "1", result: "Part 1 - Frequency: 599"},
                2: {day: "1", part: "2", result: "Part 2 - Frequency reached twice: 81204"}}
    };
    this.setCartTemplateState = this.setCartTemplateState.bind(this);
    this.addPuzzleCards = this.addPuzzleCards.bind(this);
  }

  addPuzzleCards() {
    const cards = [];
    for (var i = 1; i <= Object.keys(this.state.solved).length; i++) {
      cards.push(<CardTemplate callback={this.setCartTemplateState} cardType={"puzzleCard"} day={this.state.solved[i].day} result={this.state.solved[i].result}/>);
    }
    return cards;
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
          {this.addPuzzleCards()}
        </Grid>
      </div>
    );
  }

  setCartTemplateState(value) {
    this.setState(value);
  }
}

export default App;
