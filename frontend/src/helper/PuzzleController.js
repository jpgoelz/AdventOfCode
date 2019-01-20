export async function puzzleController() {
  this.setState({ loading: true });
  const response = await fetch(
    "/api/adventOfCode?day=" + this.state.day + "&part=" + this.state.value
  );
  let delay = duration => new Promise(resolve => setTimeout(resolve, duration));
  await delay(2000);
  try {
    const data = await response.json();
    const content = data.content;
    const message = data.message;
    if (response.ok) {
      this.setState({ result: content, loading: false });
    } else {
      this.setState({ result: message, loading: false });
    }
  } catch (e) {
    this.setState({ result: "There has been a technical error." });
    this.setState({ loading: false });
  }
}
