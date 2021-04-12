### Leetcode 721 Accounts Merge
    1. "parents" array tracks indexes of accounts
    2. builds the Map<account, index>, traverses the accounts and connect index by same account.
    3. builds Map<index, TreeSet> by step2's map
    4. translates the Map<index, Treeset> to List<name, List>