import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Typography from "@material-ui/core/Typography";

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

function PuzzleCard(props) {
  const { classes } = props;

  return (
    <Typography className={classes.title} color="textSecondary" gutterBottom>
      Puzzle
    </Typography>
  );
}

PuzzleCard.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(PuzzleCard);
