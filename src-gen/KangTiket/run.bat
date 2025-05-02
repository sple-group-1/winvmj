echo SELECT 'CREATE DATABASE onlineticketing_product_kangtiket' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'onlineticketing_product_kangtiket') \gexec | psql "postgresql://postgres:postgres@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:postgres@localhost/onlineticketing_product_kangtiket"

java -cp onlineticketing.product.kangtiket --module-path onlineticketing.product.kangtiket -m onlineticketing.product.kangtiket