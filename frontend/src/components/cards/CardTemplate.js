import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import IconButton from "@material-ui/core/IconButton";
import Typography from "@material-ui/core/Typography";
import FloatingActionButtons from "../buttons/FloatingActionButtons";
import PuzzleCard from "./PuzzleCard";
import AddNewCard from "./AddNewCard";

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

function renderAddNewCardActions(cardType, classes) {
  if (cardType == "newCard") {
    return (
      <CardActions className={classes.actions} disableActionSpacing>
        <IconButton aria-label="Add to favorites">
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

function CardTemplate(props) {
  const { classes, cardType } = props;

  return (
    <Card className={classes.card}>
      <CardContent>
        <Typography
          className={classes.title}
          color="textSecondary"
          gutterBottom
        >
          Word of the Day
        </Typography>
        <Typography variant="h5" component="h2">
          be lent
        </Typography>
        <Typography className={classes.pos} color="textSecondary">
          adjective
        </Typography>
        <Typography component="p">
          well meaning and kindly.
          <br />
          {'"a benevolent smile"'}
        </Typography>
        {renderPuzzleCardContent(cardType)}
        {renderAddNewCardContent(cardType)}
      </CardContent>
      {renderAddNewCardActions(cardType, classes)}
    </Card>
  );
}

CardTemplate.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(CardTemplate);
