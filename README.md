# Disjoint_Set_Union_DSU_Java

# input
alice bob cindy daniel emma fiona grey hudson ian jacob

# before press Init Value
we have parent array
|(0)alice |(1)bob |(2)cindy |(3)daniel|(4)emma |(5)fiona|(6)grey |(7)hudson |(8)ian |(9)jacob|
|null     |null   |null     |null     |null    |null    |null    |null      |null   |null    |

# before press Init Value
we have parent array

|(0)alice |(1)bob |(2)cindy |(3)daniel|(4)emma |(5)fiona|(6)grey |(7)hudson |(8)ian |(9)jacob|

|(0)alice |(1)bob |(2)cindy |(3)daniel|(4)emma |(5)fiona|(6)grey |(7)hudson |(8)ian |(9)jacob|

# after press Union "alice" and "bob"
we have parent array

|(0)alice     |(1)bob       |(2)cindy |(3)daniel|(4)emma  |(5)fiona |(6)grey |(7)hudson |(8)ian |(9)jacob|

|**(0)alice** |**(0)alice** |(2)cindy |(3)daniel|(4)emma |(5)fiona|(6)grey |(7)hudson |(8)ian |(9)jacob|


# after press Union "ian" and "cindy"
we have parent array

|(0)alice     |(1)bob       |(2)cindy     |(3)daniel|(4)emma  |(5)fiona|(6)grey |(7)hudson |(8)ian        |(9)jacob|

|(0)alice     |(0)alice     |**(2)cindy** |(3)daniel|(4)emma  |(5)fiona|(6)grey |(7)hudson |**(2)cindy**  |(9)jacob|