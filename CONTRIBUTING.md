# How to Contribute

All types of contributions are encouraged and valued.

If you would like to contribute code to Igdbclient you can do so through GitHub by forking the repository and
sending a pull request.

Before submitting a PR, get working code in a personal branch with tests passing:

```
./gradlew check styleCheck
```

The `check` task includes `checkKotlinAbi`. After an intentional public API change, run
`./gradlew updateKotlinAbi` and review the changes to the ABI dumps under each library's `api/` directory.

Please make every effort to follow existing conventions and style in order to keep the code as
readable as possible.

Consult [GitHub Help](https://help.github.com/articles/about-pull-requests/) for more
information on using pull requests.
