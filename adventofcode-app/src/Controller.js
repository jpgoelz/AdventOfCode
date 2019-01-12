import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormHelperText from "@material-ui/core/FormHelperText";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";

const styles = theme => ({
  root: {
    display: "flex"
  },
  formControl: {
    margin: theme.spacing.unit * 3
  },
  group: {
    margin: `${theme.spacing.unit}px 0`
  }
});

class Controller extends Component {
  constructor(props) {
    super(props);
    this.state = {
      day: "",
      part: "",
      result: "hh",
      value: ""
    };
    this.callController = this.callController.bind(this);
  }

  handleChange = event => {
    this.setState({ value: event.target.value });
  };

  render() {
    const { classes } = this.props;
    return (
      <div>
        <div className="ui input">
          <input
            type="text"
            placeholder="Which day?"
            onChange={day => this.setState({ day: day.target.value })}
          />
          <input
            type="text"
            placeholder="Part 1 or part 2?"
            onChange={part => this.setState({ part: part.target.value })}
          />
        </div>
        <Button className="ui button" onClick={this.callController}>
          Go!
        </Button>
        <div className="ui message">
          <div className="header">This is the result!</div>
          <p>{this.state.result}</p>
        </div>
        <FormControl component="fieldset" className={classes.formControl}>
          <FormLabel component="legend">Puzzle Part</FormLabel>
          <RadioGroup
            aria-label="part"
            name="part"
            className={classes.group}
            value={this.state.value}
            onChange={this.handleChange}
          >
            <FormControlLabel
              value="1"
              control={<Radio color="primary" />}
              label="Part 1"
              labelPlacement="start"
            />
            <FormControlLabel
              value="2"
              control={<Radio color="primary" />}
              label="Part 2"
              labelPlacement="start"
            />
          </RadioGroup>
          <FormHelperText>labelPlacement start</FormHelperText>
        </FormControl>
      </div>
    );
  }

  async callController() {
    const response = await fetch(
      "/api/adventOfCode?day=" + this.state.day + "&part=" + this.state.value
    );
    try {
      const data = await response.json();
      const content = data.content;
      const message = data.message;
      if (response.ok) {
        this.setState({ result: content });
      } else {
        this.setState({ result: message });
      }
    } catch (e) {
      this.setState({ result: "There has been a technical error." });
    }
  }
}

Controller.propTypes = {
  classes: PropTypes.object.isRequired
};

export default withStyles(styles)(Controller);
