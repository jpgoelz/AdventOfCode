import React, { Component } from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import IconButton from "@material-ui/core/IconButton";
import FloatingActionButtons from "../buttons/FloatingActionButtons";
import PuzzleCard from "./PuzzleCard";
import AddNewCard from "./AddNewCard";
import { puzzleController } from "../../helper/PuzzleController";

const styles = {
  card: {
    minWidth: 300,
    maxWidth: 300,
    minHeight: 300,
    margin: 10,
    position: "relative"
  },
  actions: {
    position: "absolute",
    bottom: 0
  },
  title: {
    fontSize: 14
  },
  pos: {
    marginBottom: 12
  }
};

function renderAddNewCardActions(cardType, classes, controller) {
  if (cardType == "newCard") {
    return (
      <CardActions className={classes.actions} disableActionSpacing>
        <IconButton onClick={controller}>
          <FloatingActionButtons />
        </IconButton>
      </CardActions>
    );
  }
}

function renderPuzzleCardContent(cardType) {
  if (cardType == "puzzleCard") {
    return <PuzzleCard />;
  }
}

function renderAddNewCardContent(cardType) {
  if (cardType == "newCard") {
    return <AddNewCard />;
  }
}

class CardTemplate extends Component {
  controller;
  constructor(props) {
    super(props);
    this.state = {
      part: "",
      result: "",
      value: "",
      day: "",
      loading: false
    };
    this.controller = puzzleController.bind(this);
  }

  render() {
    const { classes, cardType } = this.props;

    return (
      <Card className={classes.card}>
        <CardContent>
          {renderPuzzleCardContent(cardType)}
          {renderAddNewCardContent(cardType)}
        </CardContent>
        {renderAddNewCardActions(cardType, classes, this.controller)}
      </Card>
    );
  }
}

CardTemplate.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(CardTemplate);
