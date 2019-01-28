import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import { shallow } from "enzyme";

describe("App", () => {
  it("should add puzzle cards", () => {
    const component = shallow(<App />).dive();
    const expectedResults = [
      "Part 1 - Frequency: 599",
      "Part 2 - Frequency reached twice: 81204"
    ];
    const actualPuzzleCards = component.instance().addPuzzleCards();

    expect(
      actualPuzzleCards.map(card => card.props.result)
    ).to.have.all.members(expectedResults);

    expect(
      actualPuzzleCards.map(card => card.props.cardType)
    ).to.have.all.members(["puzzleCard", "puzzleCard"]);

    expect(actualPuzzleCards.map(card => card.props.day)).to.have.all.members([
      "1",
      "1"
    ]);

    expect(actualPuzzleCards.length).to.equal(2);
  });

  it("should render the desired childComponents", () => {
    const component = shallow(<App />).dive();

    console.log(component.childAt(0));

    expect(component.children().getElements().length).to.equal(2);

    expect(component.childAt(0).name()).to.equal(
      "WithStyles(PrimarySearchAppBar)"
    );
    expect(component.childAt(1).name()).to.equal("WithStyles(Grid)");

    expect(
      component
        .childAt(1)
        .children()
        .getElements().length
    ).to.equal(3);

    expect(
      component
        .childAt(1)
        .childAt(0)
        .name()
    ).to.equal("WithStyles(CardTemplate)");
  });

  it("renders without crashing", () => {
    const div = document.createElement("div");
    ReactDOM.render(<App />, div);
    ReactDOM.unmountComponentAtNode(div);
  });
});
