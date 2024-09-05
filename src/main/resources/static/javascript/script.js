console.log("script from js");

//get theme from localStorage
function getTheme() {
  let themeFroLocalStorage = localStorage.getItem("theme");

  if (themeFroLocalStorage) {
    return themeFroLocalStorage;
  } else {
    return "light";
  }
}

//logging current theme
//using gethteme function we are fetching theme
let currentTheme = getTheme();
console.log(currentTheme);

//todo
// Main function to change theme
function changeTheme() {
  //set to web page
  document.querySelector("html").classList.add(currentTheme);

  //set the listener to change theme by button
  const changeThemeButton = document.querySelector("#theme_change_button");

  //change the text of button
  changeThemeButton.querySelector("span").textContent =
    currentTheme == "light" ? " Dark" : "Light";

  //added event to button
  changeThemeButton.addEventListener("click", (event) => {
    console.log("event added");

    const oldTheme = currentTheme;

    if (currentTheme === "light") {
      currentTheme = "dark";
    } else {
      currentTheme = "light";
    }

    //update in localStorage
    setTheme(currentTheme);

    //remove the current theme
    document.querySelector("html").classList.remove(oldTheme);

    //add new theme as per old theme
    document.querySelector("html").classList.add(currentTheme);

    //change the text of button
    changeThemeButton.querySelector("span").textContent =
      currentTheme == "light" ? " Dark" : "Light";
  });
}

//to call function when document is loaded
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//set Theme to localStorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}
