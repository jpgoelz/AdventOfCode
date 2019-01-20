import React from "react";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Fab from "@material-ui/core/Fab";
import PlayArrow from "@material-ui/icons/PlayArrow";
import Tooltip from "@material-ui/core/Tooltip";

const styles = theme => ({
  fab: {
    margin: theme.spacing.unit
  }
});

function FloatingActionButtons(props) {
  const { classes } = props;
  return (
    <Tooltip title="Start Puzzle" placement="right">
      <Fab color="primary" aria-label="Add" className={classes.fab}>
        <PlayArrow />
      </Fab>
    </Tooltip>
  );
}

FloatingActionButtons.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(FloatingActionButtons);
