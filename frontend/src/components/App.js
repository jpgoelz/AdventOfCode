import React, { Component } from "react";
import "./App.css";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import PrimarySearchAppBar from "./appbar/PrimarySearchAppBar";
import CardTemplate from "./cards/CardTemplate";
import Grid from "@material-ui/core/Grid";

const styles = theme => {
  return {
    alignCards: {
      [theme.breakpoints.up("xs")]: {
        justifyContent: "center",
        margin: 0
      },
      [theme.breakpoints.up("sm")]: {
        justifyContent: "flex-start",
        margin: 10
      }
    }
  };
};

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      part: "",
      solved: {
        1: { day: "1", part: "1", result: "Part 1 - Frequency: 599" },
        2: {
          day: "1",
          part: "2",
          result: "Part 2 - Frequency reached twice: 81204"
        }
      }
    };
    this.setPuzzleResult = this.setPuzzleResult.bind(this);
    this.addPuzzleCards = this.addPuzzleCards.bind(this);
  }

  addPuzzleCards() {
    const cards = [];
    for (var i = 1; i <= Object.keys(this.state.solved).length; i++) {
      cards.push(
        <CardTemplate
          callback={this.setPuzzleResult}
          cardType={"puzzleCard"}
          day={this.state.solved[i].day}
          result={this.state.solved[i].result}
        />
      );
    }
    return cards;
  }

  render() {
    const { classes } = this.props;

    return (
      <div className="App">
        <PrimarySearchAppBar />
        <Grid
          className={classes.alignCards}
          container
          direction="row"
          alignItems="flex-start"
        >
          <CardTemplate callback={this.setPuzzleResult} cardType={"newCard"} />
          {this.addPuzzleCards()}
        </Grid>
      </div>
    );
  }

  setPuzzleResult(value) {
    console.log(value);
    let nextSolved = Object.keys(this.state.solved).length + 1;
    let solved = Object.assign({}, this.state.solved);
    solved[nextSolved] = value;
    console.log(solved);
    this.setState({ solved });
  }
}

App.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(App);
