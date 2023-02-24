# Contributing

When contributing to this repository ensure that the work you are doing has a corresponding Jira ticket in the
appropriate project. Qantas Jira can be found at [jira.qantas.com.au](https://jira.qantas.com.au/). You should include
the Jira ticket number in your commit messages.

## Git Workflow

We use the [Skullcandy workflow](https://www.endpoint.com/blog/2014/05/02/git-workflows-that-work). Here’s the
breakdown:

- Use a feature branch for each piece of work (branch from master)
- PR back to master when you're ready to go to prod
- There is a separate QA branch called `develop`. This branch goes to dev and sit environments. You do not need a PR to
  this branch
- The branch name should reflect the Jira ID

## Pull Request Process

1. Anyone with access to this repository can raise a Pull Request
2. Merging to master is controlled by the `.github/CODEOWNERS` file
3. Ensure you are up to date with the `master` branch.
4. We prefer `git rebase master` rather than `git merge master`.
5. Two approvals are required before merging is allowed.
6. A passing CI build is required before merging is allowed

## Versioning

Versioning for this project should be handled as part of the CI process. Version numbers follow the following format:

Format: `{YY}.{MMDD}.{BUILD_NUMBER}` Example: `20.0512.23`

## Style

Obviously the most important statement: we use spaces for indentation.

Qantas Loyalty have their own [styleguide](https://github.com/qantasloyalty/styleguide) based on Google's.

Changes include (see the styleguide repo for a complete list):

1. For imports, QL LSL do not use import wildcards so in your IDE change your class count and names count for using
   import with \* to 999
2. Change your line length to 150 characters
3. Change your AbbreviationAsWordInName setting to allow Abbreviation Length to be 2 as we have some integration test
   classes named using 2 consecutive capital letters

We do not specify an IDE to use for your development but we suggest either Eclipse or IntelliJ so that you can import
the
[Qantas Loyalty style guide XML](https://github.com/qantasloyalty/styleguide/blob/master/checkstyle/qantasloyalty_checks.xml)
to make it easy to follow our style.

We use [SonarQube](https://sonar.qantasloyalty.io) to enforce style rules too as well as similar rules to Checkstyle and
PMD. SonarQube will also help highlight problems with the code such as bugs and duplications.

We strongly encourage you to install [SonarLint](https://www.sonarlint.org/) for your IDE.

By using our standard workflow, all Pull Requests should be automatically commented on by SonarQube.

## New commit

1. Make sure there is at-least 80% test coverage, and you are not reducing the overall coverage when adding a new
   commit.
2. Make sure docker compose is updated and the application can be run using docker compose. If you are facing issues
   running docker compose check this [page](https://confluence.qantas.com.au/display/LSL/Docker+Compose).
3. See if swagger documentation needs to be updated. You might also want to update the postman collection. All swagger
   docs can be accessed [here](https://admin.lsl.sit.qantasloyalty.net/api-index.html).
4. See if README needs to be updated.
5. Have a quick read on our
   [logging and member privacy](https://confluence.qantas.com.au/display/LSL/Logging+and+Member+Privacy).

## Debugging/logs/Troubleshooting

- [Spring boot admin](https://admin.lsl.sit.qantasloyalty.net/admin)
- [Splunk logs](https://splunk.qantasloyalty.io/en-US/app/search/search?earliest=-24h%40h&latest=now&q=search%20index%3D%22lsl-sit-app%22&display.page.search.mode=fast)

## Meetings and events

Feel free to join our:

- Stand up every day at 10:00 AM [Google Meet](https://meet.google.com/ggr-xejo-dqb), and
- Tech forum –
  [Calendar event](https://calendar.google.com/event?action=TEMPLATE&tmeid=NGtzMDlvYnV0czQ4NWZxNGlnc2hoYXRmbTdfMjAyMDA2MTJUMDAzMDAwWiByYW5qZWV0aC50aGF0dGFyaXlpbEBxYW50YXNsb3lhbHR5LmNvbQ&tmsrc=ranjeeth.thattariyil%40qantasloyalty.com&scp=ALL),
  [Hangout](https://meet.google.com/itj-hpfb-tcs)
