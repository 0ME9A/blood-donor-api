# Contributing to Blood Donor API

We warmly welcome contributions to the Blood Donor API project! Whether you're looking to fix a bug, add a new feature, improve documentation, or just have a great idea, your help is highly valued.

Please take a moment to read this guide to understand how you can contribute effectively.

## Ways to Contribute

There are many ways you can contribute to the Blood Donor API:

* **Reporting Bugs:** Help us identify and fix issues by reporting bugs clearly and concisely.
* **Suggesting Enhancements:** Share your ideas for new features or improvements to the API.
* **Writing Code:** Contribute code by fixing bugs, implementing new features, or refactoring existing code.
* **Improving Documentation:** Help us make the API easier to understand by improving the README, API documentation, or creating tutorials.
* **Reviewing Code:** Participate in code reviews to ensure the quality and consistency of the codebase.
* **Testing:** Help us ensure the API is stable and reliable by writing and running tests.

## Getting Started

1.  **Fork the Repository:** Click the "Fork" button in the top right corner of the repository on GitHub. This will create a copy of the repository under your GitHub account.

2.  **Clone Your Fork:** Clone the forked repository to your local machine:
    ```bash
    git clone [https://github.com/0me9a/blood-donor-api.git](https://github.com/0me9a/blood-donor-api.git)
    cd blood-donor-api
    ```

3.  **Set Up Your Development Environment:** Follow the instructions in the [README.md](README.md) file to set up your local development environment, including JDK, Maven, and database configuration.

4.  **Create a New Branch:** Before making any changes, create a new branch from the `main` branch:
    ```bash
    git checkout -b feature/your-feature-name
    ```
    or
    ```bash
    git checkout -b bugfix/your-bug-fix-name
    ```
    Choose a descriptive name for your branch.

## Making Changes

1.  **Make Your Changes:** Implement your feature, bug fix, or documentation improvement. Follow the project's coding standards and best practices.

2.  **Write Tests:** If you're adding new functionality or fixing a bug, please write tests to ensure the changes work correctly and prevent regressions.

3.  **Format Your Code:** Ensure your code is properly formatted according to the project's style guidelines (if any are defined). Maven might have formatting plugins you can use.

4.  **Commit Your Changes:** Commit your changes with clear and concise commit messages. Follow these guidelines:
    * Separate the subject line from the body with a blank line.
    * Limit the subject line to 50 characters.
    * Capitalize the subject line.
    * Do not end the subject line with a period.
    * Use the imperative mood ("Fix bug", "Add feature").
    * Optionally, add a more detailed body explaining the changes.

    Example:
    ```
    git commit -m "feat: Implement search by date of last donation"

    Added a new API endpoint to search donors based on their last donation date.
    Allows searching within a date range or for a specific date.
    Updated the DonorRepository, DonorService, and DonorController.
    Added unit tests for the new functionality.
    ```

5.  **Push Your Changes:** Push your branch to your forked repository on GitHub:
    ```bash
    git push origin feature/your-feature-name
    ```

## Submitting a Pull Request

1.  **Create a Pull Request:** Go to your forked repository on GitHub and click the "Compare & pull request" button.

2.  **Provide a Clear Title and Description:**
    * **Title:** Use a clear and concise title that summarizes your changes.
    * **Description:** Provide a detailed explanation of your changes, the problem you are solving (if it's a bug fix), and any context that might be helpful for reviewers. Include links to any related issues.

3.  **Review Process:** Your pull request will be reviewed by one or more project maintainers. They may provide feedback or ask for revisions. Please be responsive to their comments and make the necessary changes.

4.  **Merge:** Once your pull request is approved, it will be merged into the `main` branch.

## Code Style and Guidelines

Please follow the existing code style and conventions used in the project. If there are specific style guidelines defined (e.g., using a `.editorconfig` file or Maven formatting plugins), please adhere to them.

* Write clean, readable, and well-commented code.
* Keep methods and functions concise and focused.
* Follow SOLID principles where applicable.
* Write unit tests to cover your changes.

## Reporting Bugs

When reporting a bug, please include the following information:

* **Version of the API:** (if applicable)
* **Steps to reproduce the bug:** Be as detailed as possible.
* **Expected behavior:** What did you expect to happen?
* **Actual behavior:** What happened instead?
* **Error messages or logs:** Include any relevant error messages or logs.
* **Your environment:** Operating system, Java version, etc.

## Suggesting Enhancements

When suggesting an enhancement, please be clear and specific about the feature or improvement you'd like to see. Explain the motivation behind the suggestion and how it would benefit the project.

## License

By contributing to the Blood Donor API, you agree that your contributions will be licensed under the project's [MIT License](LICENSE).

## Code of Conduct

Please note that this project has a [Code of Conduct](CODE_OF_CONDUCT.md). By participating in this project, you agree to abide by its terms.

Thank you for your contributions! We appreciate your help in making the Blood Donor API a better project.
