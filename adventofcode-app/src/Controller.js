import React, { Component } from "react";
import Button from "@material-ui/core/Button";

class Controller extends Component {
  constructor(props) {
    super(props);
    this.state = {
      day: "",
      part: "",
      result: "hh"
    };
    this.callController = this.callController.bind(this);
  }

  render() {
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
      </div>
    );
  }

  async callController() {
    const response = await fetch(
      "/api/adventOfCode?day=" + this.state.day + "&part=" + this.state.part
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

export default Controller;
