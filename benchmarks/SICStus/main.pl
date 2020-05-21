(:-set_prolog_flag(redefine_warnings,off)).
(:-[boyer],bench(100)).
(:-[browse],bench(100)).
(:-[chat_parser],bench(100)).
(:-[crypt],bench(10000)).
(:-[deriv],bench(100000)).
(:-[dynamic_unit_clause],bench(10000)).
(:-[fast_mu],bench(10000)).
(:-[flatten],bench(100000)).
(:-[itak],bench(100)).
(:-[meta_qsort],bench(5000)).
(:-[mu],bench(10000)).
(:-[nreverse],bench(100000)).
(:-[nreverse_builtin],bench(100000)).
(:-[poly],bench(1000)).
(:-[primes],bench(10000)).
(:-[prover],bench(10000)).
(:-[qsort],bench(100000)).
(:-[queens],bench(10000)).
(:-[query],bench(100000)).
(:-[reducer],bench(500)).
(:-[sendmore],bench(500)).
(:-[simple_analyzer],bench(500)).
(:-[tak],bench(1000)).
(:-[unify],bench(20000)).
(:-[zebra],bench(500)).
(:-halt).
